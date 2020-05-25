##  Android 部分

主要编制人：李宗淦

2020/5/18：上传Android部分

2020/5/22：初步实现客户端服务器通信

2020/5/23：添加webSocket功能

2020/5/24：规范消息格式



uri ws://134.175.14.15:8080/demo/websocket/1

目前android发送的消息包括（都是String类型）
方位：**forward，back，left，right**
获取地图：**refresh_map**
目的地坐标：未定，按输入
需要的消息为map，格式未定