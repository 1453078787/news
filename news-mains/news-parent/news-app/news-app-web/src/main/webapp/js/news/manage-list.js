$(function(){

    $.ajax({
        type: "POST",
        url: conf.ctx + "/type/list.do",
        dataType: 'json',
        success: function(response){
            if(response.success){
                initTabs(response.body);
            }else{
                toastr["error"](response.message?response.message:"获取分类失败","温馨提示");
            }
            $("#close-modal").click();
        },
        error: function() {
            toastr["error"]("请求失败","温馨提示");
        }
    });


});




function initTabs(tab) {
    $.each(tab , function(i , t) {
        var $table = $("<table class='table table-striped table-bordered' style='width: 1084px'><thead><tr><th></th><th>标题</th> <th>点击量</th><th>最近更新时间</th><th>状态</th></tr></thead></table>");

        var $div1 = $("<div class='tab-pane'></div>");
        var $li1 = $("<li><a data-tab>标签1</a></li>");

        $("#ul-tab").append($li1);
        $li1.find("a").attr("href", "#div" + i);
        $li1.find("a").text(t.newTypeName);
        $("#content-tab").append($div1);
        $div1.attr("id", "div" + i);
        $div1.append($table);
        initDataTable($table,t.newTypeId);
        if (i == 2) {
            $li1.addClass("active");
            $div1.addClass("active");
        }
    });
    $("table").each(function(){
        $(this).attr("style","width:100%");
    })

}



function initDataTable($selctor, typeId){
    $selctor.DataTable( {
        //"processing": true,
        //"serverSide": true,
        // "ajax": conf.ctx + "/subject/list.do",
        "ajax":conf.ctx + "/manage/list-type.do?typeId=" + typeId,
        "retrieve":true,
        // "deferRender": true,
        "oLanguage" : {
            "sLengthMenu" : "每页显示 _MENU_ 条",
            "sZeroRecords" : "没有找到符合条件的数据",
            "sInfo" : "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",
            "sInfoEmpty" : "没有记录",
            "sInfoFiltered" : "(从 _MAX_ 条记录中过滤)",
            "sSearch" : "搜索",
            "sProcessing" : "数据加载中...",
            "oPaginate" : {
                "sFirst" : "首页",
                "sPrevious" : "上一页",
                "sNext" : "下一页",
                "sLast" : "尾页"
            }
        },
        "columns": [
            { "data": function(row){
                    return "<input type='checkbox' id='"+ row['newId'] +"'>"
                }
            },
            { "data": function(row){
                    return "<a href='#'>"+ row['newName'] +"</a>"
                }
            },
            { "data": "viewNumber" },
            { "data": function(row){
                    return formatDateTime(row['updatedTime']);
                }
            },
            { "data": "newSatus"}
        ]
    });
    $selctor.dataTable().fnDestroy();
    $selctor.DataTable();
}

function addNewType(){

    var validateResult =  $("#form-params").validationEngine('validate');
    if (!validateResult) {
        return false;
    }
    var newType=$("#form-params").serializeJsonObject();
    $.ajax({
        type: "POST",
        url: conf.ctx + "/type/add.do",
        contentType: "application/json",
        data: JSON.stringify(newType),
        dataType: 'json',
        success: function(response){
            if(response.success){
                toastr["success"](response.message?response.message:"新增成功","温馨提示");
            }else{
                toastr["error"](response.message?response.message:"新增失败","温馨提示");
            }
            $("#close-modal").click();
        },
        error: function() {
            toastr["error"]("请求失败","温馨提示");
        }
    });
    // $('#myModal').modal('hide','fit');
}

function formatDateTime(strTime) {

    if(strTime != "" && strTime != null){
        var date = new Date(strTime);

        var year = date.getFullYear();

        var month = date.getMonth() + 1;
        if (month.toString().length < 2) {
            month = "0" + month;
        }

        var dt = date.getDate();
        if (dt.toString().length < 2) {
            dt = "0" + dt;
        }

        var hh = date.getHours();
        if(hh.toString().length < 2){
            hh = "0" + hh;
        }

        var mm = date.getMinutes();
        if(mm.toString().length < 2){
            mm = "0" + mm;
        }

        var ss = date.getMilliseconds();
        if(ss.toString().length < 2){
            ss = "0" + ss;
        }
        return year + "-" + month + "-" + dt + " " + hh + ":" + mm + ":" +ss ;
    } else {
        return "";
    }

}