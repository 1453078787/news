$.fn.modal.Constructor.prototype.enforceFocus = function () {
};
var newsId;
$(function () {

    ajaxTab();


});

//上传 并且  显示图片
function fileChange(type) {
    var obj = document.getElementById("file");
    if (type == "img") {
        if (!obj.value.endsWith('jpg') && !obj.value.endsWith('png')) {
            toastr["error"]("请选择图片", "温馨提示");
            return;
        }
    }
    if (type == "vedio") {
        if (!obj.value.endsWith('ogg')) {
            toastr["error"]("请选择视频", "温馨提示");
            return;
        }
    }

    var formData = new FormData();
    formData.append("file", obj.files[0]);
    $.ajax({
        type: 'post',
        url: conf.ctx + "/upload.do",
        dataType: "json",
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
        success: function (response) {
            if (response.success) {
                if (type == "img") {
                    // <a href='docs/img/img3.jpg' data-group="example-3" data-toggle="lightbox" data-lightbox-group="example-3" data-group-index="2"><img src="docs/img/img3.jpg" class="img-rounded" alt=""></a>
                    //     $("#news-content").append("<a href='" + conf.ctx + "/upload/" + response.body + "' data-toggle='lightbox' data-group='example-3' data-lightbox-group='example-3' data-group-index='2\"><img style='height: 10%;width: 10%' src='" + conf.ctx + "/upload/" + response.body + "' class='img-rounded' alt=''></a><div><br/></div><div><br/></div>");
                    $("#news-content").append("<div  align='center'><img style='height: 200px;width: 200px' src='" + conf.ctx + "/upload/" + response.body + "'/></div><div><br/></div><div><br/></div>");
                } else {
                    $("#content-vedio").append("<div  align='center'><video src='" + conf.ctx + "/upload/" + response.body + "' controls='controls'></video></div>");
                }
            }
        },
        error: function () {
            toastr["error"]("导入失败", "温馨提示");
        }
    });
}

//向后台请求tab_id和tab_name
function ajaxTab() {
    $.ajax({
        type: "POST",
        url: conf.ctx + "/type/list.do",
        dataType: 'json',
        success: function (response) {
            if (response.success) {
                initTabs(response.body);
            } else {
                toastr["error"](response.message ? response.message : "获取分类失败", "温馨提示");
            }
            $("#close-modal").click();
        },
        error: function () {
            toastr["error"]("请求失败", "温馨提示");
        }
    });
}

//初始化tab，qppend在标签里
function initTabs(tab) {
    $.each(tab, function (i, t) {

        var $dataTable = $("<div id='dataTable" + (i + 1) + "'><div class='dataTables_wrapper no-footer'><div class='table-scrollable auto min'><table class='data-table-min table table-striped table-bordered table-hover table-checkable order-column dataTable no-footer'></table></div><div class='dataTables-pageNav'></div></div>\</div>")

        var $table = $("<table class='table table-striped table-bordered' style='width: 100%'><thead><tr><th></th><th>标题</th> <th>点击量</th><th>最近更新时间</th><th>状态</th></tr></thead></table>");
        var $div1 = $("<div class='tab-pane'></div>");
        var $li1 = $("<li><a data-tab>标签1</a></li>");

        $("#ul-tab").append($li1);
        $li1.find("a").attr("href", "#div" + i);
        $li1.find("a").text(t.newTypeName);
        $("#content-tab").append($div1);
        $div1.attr("id", "div" + i);
        // $div1.append($table);
        // initDataTable($table,t.newTypeId);
        $div1.append($dataTable);
        initDataTables("#dataTable" + (i + 1), t.newTypeId);
        if (i == 2) {
            $li1.addClass("active");
            $div1.addClass("active");
        }
    });
}

function searchParams(typeId) {
    var param = {};
    param.newTypeId = typeId;
    param.page = 1;
    param.pagesize = 20;
    return param;
}

function initDataTables(tableId, typeId) {
    var dateTable = new DataTable({
        id: tableId,
        url: conf.ctx + "/manage/list-type.do",
        params: searchParams(typeId),
        type: 'post',
        selectOne: true,  //单选
        pageInterval: 10,
        columns: [
            {
                field: "newId", title: "", className: "center", format: function (val, row, i) {
                return "<input type='checkbox' id='" + val + "'>";
            }
            },
            {
                field: "newName", title: "标题", className: "center", format: function (val, row, i) {
                return "<a href=" + conf.ctx + "/manage/to-detail.do?newId=" + row['newId'] + ">" + val + "</a>";
            }
            },
            {field: "viewNumber", title: "点击量", className: "center"},
            {
                field: "updatedTime", title: "最近更新时间", className: "center", format: function (val, row, i) {
                return formatDateTime(val);
            }
            },
            {field: "newSatus", title: "状态", className: "center"}
        ]
    });
    dateTable.init();
}

//初始化每个tab里的table
function initDataTable($selctor, typeId) {
    $selctor.DataTable({
        //"processing": true,
        //"serverSide": true,
        // "ajax": conf.ctx + "/subject/list.do",
        "ajax": conf.ctx + "/manage/list-type.do?typeId=" + typeId,
        "retrieve": true,

        // "deferRender": true,
        "oLanguage": {
            "sLengthMenu": "每页显示 _MENU_ 条",
            "sZeroRecords": "没有找到符合条件的数据",
            "sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",
            "sInfoEmpty": "没有记录",
            "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",
            "sSearch": "搜索",
            "sProcessing": "数据加载中...",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "尾页"
            }
        },
        "columns": [
            {
                "data": function (row) {
                    return "<input type='checkbox' id='" + row['newId'] + "'>"
                }
            },
            {
                "data": function (row) {
                    return "<a href=" + conf.ctx + "/manage/to-detail.do?newId=" + row['newId'] + ">" + row['newName'] + "</a>";
                }
            },
            {"data": "viewNumber"},
            {
                "data": function (row) {
                    return formatDateTime(row['updatedTime'].time);
                }
            },
            {"data": "newSatus"}
        ]
    });
    $selctor.dataTable().fnDestroy();
    $selctor.DataTable();
}

//点击添加分类里的保存按钮触发事件
function addNewType() {

    var validateResult = $("#form-params").validationEngine('validate');
    if (!validateResult) {
        return false;
    }
    var newType = $("#form-params").serializeJsonObject();
    $.ajax({
        type: "POST",
        url: conf.ctx + "/type/add.do",
        contentType: "application/json",
        data: JSON.stringify(newType),
        dataType: 'json',
        success: function (response) {
            if (response.success) {
                toastr["success"](response.message ? response.message : "新增成功", "温馨提示");
                flash();
            } else {
                toastr["error"](response.message ? response.message : "新增失败", "温馨提示");
            }
        },
        error: function () {
            toastr["error"]("请求失败", "温馨提示");
        }
    });
    // $('#myModal').modal('hide','fit');
}

//格式化时间   yyyy-MM-dd HH:mm:ss
function formatDateTime(strTime) {

    if (strTime != "" && strTime != null) {
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
        if (hh.toString().length < 2) {
            hh = "0" + hh;
        }

        var mm = date.getMinutes();
        if (mm.toString().length < 2) {
            mm = "0" + mm;
        }

        var ss = date.getSeconds();
        if (ss.toString().length < 2) {
            ss = "0" + ss;
        }
        return year + "-" + month + "-" + dt + " " + hh + ":" + mm + ":" + ss;
    } else {
        return "";
    }

}


//点击删除分类
$("#delete-type").click(function () {
    $("#type-select").empty();
    initTabSelect2($("#type-select"));
});

//初始化类型select2
function initTabSelect2($selector) {
    $selector.select2({
        language: "zh-CN",
        placeholder: '请选择分类'
    });
    $.ajax({
        type: 'POST',
        url: conf.ctx + "/type/list.do",
        dataType: "json",
        success: function (response) {
            if (response.success) {
                $.each(response.body, function (index, item) {
                    $selector.append("<option value=" + item.newTypeId + ">" + item.newTypeName + "</option>");
                });
                $selector.val(null).trigger("change");
            } else {
                toastr["error"](response.message ? response.message : "查询新闻分类失败", "温馨提示");
            }
        },
        error: function (e) {
            toastr["error"]("连接失败", "温馨提示");
        }
    });
}

//点击删除分类里的确定删除按钮触发
function deleteNewType() {
    var validateResult = $("#delete-params").validationEngine('validate');
    if (!validateResult) {
        return false;
    }
    $.ajax({
        type: 'POST',
        url: conf.ctx + "/type/delete.do",
        data: {"typeId": $("#type-select").selectpicker("val")},
        dataType: "json",
        success: function (response) {
            if (response.success) {
                toastr["success"](response.message ? response.message : "删除新闻分类成功", "温馨提示");
                flash();
            } else {
                toastr["error"](response.message ? response.message : "删除新闻分类失败", "温馨提示");
            }
        },
        error: function (e) {
            toastr["error"]("连接失败", "温馨提示");
        }
    });

}

//新增删除后刷新页面
function flash() {

    $(".close").click();
    $("#ul-tab").empty();
    $("#content-tab").empty();

    ajaxTab();
}

//点击编辑新闻触发
$("#edit-news").click(function () {
    getNewId();
    $("#type2-select").empty();
    initTabSelect2($("#type2-select"));
    $("#news-content").html("");
    $("#content-vedio").html("");
    if (newsId.length == 1) {
        $.ajax({
            type: "POST",
            url: conf.ctx + "/manage/detail.do",
            data: {"newId": newsId[0]},
            dataType: 'json',
            success: function (response) {
                if (response.success) {
                    var body = response.body;
                    $("#type2-select").val(body.newTypeId).trigger("change");
                    $("#news-title").val(body.newName);
                    var content = body.newContent.split("<div class='sperator'><br></div>");
                    $("#news-content").html(content[0]);
                    $("#content-vedio").html(content[1]);
                } else {
                    toastr["error"](response.message ? response.message : "查询详情失败", "温馨提示");
                }
            },
            error: function () {
                toastr["error"]("请求失败", "温馨提示");
            }
        });
    }
});

//点击选择文件触发
$("#select-file").click(function () {
    $("#file").attr("onchange", "fileChange('img')");
    $("#file").click();
});

//点击上传视频触发
$("#upload-vedio").click(function () {
    if ($("#content-vedio").find("video").length == 2) {
        toastr["error"]("最多上传两个视频", "温馨提示");
        return;
    }
    $("#file").attr("onchange", "fileChange('vedio')");
    $("#file").click();
});

//点击上传新闻
$("#upload-news").click(function () {
    $("#div-value").val($("#news-content").html());

    var validateResult = $("#edit-params").validationEngine('validate');
    if (!validateResult) {
        return false;
    }
    addnews("PUT");

});

function addnews(type) {
    var editNews = $("#edit-params").serializeJsonObject();
    editNews.newContent = $("#news-content").html() + "<div class='sperator'><br></div>" + $("#content-vedio").html();
    editNews.newSatus = type;
    if (newsId.length == 1) {
        editNews.newId = newsId[0];
    }
    $.ajax({
        type: "POST",
        url: conf.ctx + "/manage/put.do",
        contentType: "application/json",
        data: JSON.stringify(editNews),
        dataType: 'json',
        success: function (response) {
            if (response.success) {
                toastr["success"](response.message ? response.message : "新增成功", "温馨提示");
                $(".close").click();
                flash();
            } else {
                toastr["error"](response.message ? response.message : "新增失败", "温馨提示");
            }
        },
        error: function () {
            toastr["error"]("请求失败", "温馨提示");
        }
    });
}


$("#save-news").click(function () {
    $("#div-value").val($("#news-content").html());
    addnews("SAVE");
});

//点击删除视频
$("#delete-vedio").click(function () {
    $("#content-vedio").empty();
});

function deleteNew() {

    getNewId();
    if(newsId.length == 0) {
        toastr["error"]("请选择一条数据", "温馨提示");
        return false;
    }
    $.ajax({
        type: 'POST',
        url: conf.ctx + "/manage/delete.do",
        data: {"newId": newsId[0]},
        dataType: "json",
        success: function (response) {
            if (response.success) {
                toastr["success"](response.message ? response.message : "删除新闻成功", "温馨提示");
                flash();
            } else {
                toastr["error"](response.message ? response.message : "删除新闻失败", "温馨提示");
            }
        },
        error: function (e) {
            toastr["error"]("连接失败", "温馨提示");
        }
    });
}

function getNewId() {
    newsId = [];
    $("input[type='checkbox']").each(function () {
        if ($(this).prop("checked")) {
            newsId.push($(this).prop("id"));
        }
    });
    if (newsId.length > 1) {
        toastr["error"]("只能选择一条数据", "温馨提示");
        return false;
    }
}

