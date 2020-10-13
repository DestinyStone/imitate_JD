# 项目基本架构

+ jar项目
    + imitatejd_parent

    + imitatejd_api
    
    + imitatejd_common

    + imitatejd_common_controller

    + imitatejd_common_service
 
+ web项目
    + imitatejd_passport_controller
        + tomcat port 8081
    + imitatejd_passport_service
        + tomcat port 9091
        + dubbo port 22021
    
    + imitatejd_item_controller
        + tomcat port 8082
    + imitatejd_item_service
        + tomcat port 9092
        + dubbo port 29092