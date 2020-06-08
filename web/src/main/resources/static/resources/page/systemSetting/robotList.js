layui.use(['form', 'layer', 'laydate', 'table', 'laytpl'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#robotList',
        url: '../../json/robotList.json',
        cellMinWidth: 95,
        page: true,
        height: "full-125",
        limit: 20,
        limits: [10, 15, 20, 25],
        id: "robotListTable",
        cols: [[
            {type: "checkbox", fixed: "left", width: 50},
            {field: 'robotId', title: 'ID', width: 30, align: "center"},
            {field: 'robotName', title: '机器人名称', width: 350, align: "center"},
            {field: 'nowUser', title: '当前使用者', align: 'center'},
            {field: 'robotState', title: '机器人状态', align: 'center', templet: "#robotState"},
            {title: '操作', width: 180, templet: '#robotListBar', fixed: "right", align: "center"}
        ]]
    });


    //添加
    function addRobot(edit) {
        var index = layui.layer.open({
            title: "添加机器人",
            type: 2,
            content: "robotAdd.html",
            success: function (layero, index) {
                var body = layui.layer.getChildFrame('body', index);
                if (edit) {
                    body.find(".robotName").val(edit.robotName);
                    body.find(".robotState").val(edit.robotState);
                    form.render();
                }
                setTimeout(function () {
                    layui.layer.tips('点击此处返回机器人列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize", function () {
            layui.layer.full(index);
        })
    }

    $(".addRobot_btn").click(function () {
        addRobot();
    })

    //批量删除
    $(".delAll_btn").click(function () {
        var checkStatus = table.checkStatus('robotListTable'),
            data = checkStatus.data,
            robotId = [];
        if (data.length > 0) {
            for (var i in data) {
                robotId.push(data[i].robotId);
            }
            layer.confirm('确定删除选中的机器人？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除机器人接口",{
                //     robotId : robotId  //将需要删除的robotId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            })
        } else {
            layer.msg("请选择需要删除的机器人");
        }
    })

    //列表操作
    table.on('tool(robotList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;

        if (layEvent === 'edit') { //编辑
            addRobots(data);
        } else if (layEvent === 'del') { //删除
            layer.confirm('确定删除此机器人？', {icon: 3, title: '提示信息'}, function (index) {
                // $.get("删除机器人接口",{
                //     robotId : data.robotId  //将需要删除的robotId作为参数传入
                // },function(data){
                tableIns.reload();
                layer.close(index);
                // })
            });
        } 
    });

})