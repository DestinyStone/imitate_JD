import Vue from "vue"
import VueRouter from "vue-router"
import {loginStatus, remoteLogin} from "../network/passport/passportApi";
import elementUI from "element-ui"

const index = () => import("../views/home/index");
const login = () => import("../views/login/ManagerLogin")
const IndexSubjectAttrList = () => import("../components/common/home/IndexSubjectAttrList");
const IndexSubjectSpu = () => import("../components/common/home/IndexSubjectSpu");
const IndexSubjectSku = () => import("../components/common/home/IndexSubjectSku");
const Catalog = () => import("../views/catalog/Catalog");
const Catalog1 = () => import("../views/catalog/clientcompos/Catalog1");
const Catalog2 = () => import("../views/catalog/clientcompos/Catalog2");
const Catalog3 = () => import("../views/catalog/clientcompos/Catalog3");
const CatalogEdit = () => import("../views/catalog/clientcompos/CatalogEdit");
const RemoteNetWrokError = () => import("../views/networkerror/RemoteNetWorkError");

Vue.use(VueRouter);

const vueRouter = new VueRouter({
  routes: [
    {
      path: "",
      redirect: "/index"
    },
    {
      name:"index",
      path: "/index",
      component: index,
      meta: {
        title: "后台管理系统"
      },
      children: [
        {
          path: "catalog",
          component: Catalog,
          children: [
            {
              name: "catalog1",
              path: "catalog1",
              component: Catalog1
            },
            {
              name: "catalog2",
              path: "catalog2",
              component: Catalog2
            },
            {
              name: "catalog3",
              path: "catalog3",
              component: Catalog3
            },
            {
              name: "catalogEdit",
              path: "catalogEdit",
              component: CatalogEdit
            }
          ]
        },
        {
          path: "attrList",
          component: IndexSubjectAttrList,
        },
        {
          path: "spuManager",
          component: IndexSubjectSpu
        },
        {
          path: "skuManager",
          component: IndexSubjectSku
        }

      ]
    },
    {
      name: "ManagerLogin",
      path: "/login",
      component: login,
      meta: {
        fromPath:"/",
        title: "后台管理登录页"
      }
    },
    {
      name: "remoteNetWorkError",
      path: "/remoteError",
      component: RemoteNetWrokError,
      meta: {
        title: "错误"
      }
    }
  ],
  mode: "history"
});

vueRouter.beforeEach(async (to, from, next) => {
    setTitle(to);

    pathListener(to, from, next)
  }
);

function setTitle(to) {
  if (to.matched[0] != null)
    document.title = to.matched[0].meta.title;
}

async function pathListener(to, from, next) {
  if (to.path != "/login") {
    const responseData = await loginStatus().catch(error => {return null});

    if (responseData == null && to.path != "/remoteError") {
      console.log(22222222);
      next({path: "/remoteError"});
      return;
    }

    if (responseData != null) {
      if (responseData.data.responseCode == "21000"){
        next();
        return;
      }
      if (responseData.data.responseCode == "21001") {
        new Vue().$alert("用户登录状态失效", "警告", {
          confirmButtonText: '确定',
          callback: action => {
            next({path: "/login"});
          }
        });
        return;
      }
    }

  }

  if (to.path == "/login") {
    to.matched[0].meta.fromPath = from.path;
  }
  next();
}

export default vueRouter;

