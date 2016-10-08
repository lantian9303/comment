function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}

function initDataTables(tableId, columns, queryUrl) {
    return initDataTables(tableId, columns, queryUrl, null);
}

function initDataTables(tableId, columns, queryUrl, options) {
    var scrollY = '57vh';
    if (options != null) {
        scrollY = options.scrollY == null ? '57vh' : options.scrollY;
    }
    var t = $('#' + tableId).DataTable({
//            "processing": true,
        "fixedHeader": {
            "header": true,
            "footer": true
        },
        "bLengthChange": true, //改变每页显示数据数量
        "bSort": false,
        "autoFill": true,
        "bAutoWidth": true,//自动宽度
        "searching": false,
        "pagingType": "full_numbers",
        "scrollY": scrollY,
        "scrollCollapse": true,
        "serverSide": true,
        "language": {
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "没有找到记录",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "search": "搜索:",
            "paginate": {
                "first": "首页",
                "last": "末页",
                "next": "下一页",
                "previous": "上一页"
            }
        },
        "columns": columns,
        "ajax": {
            "url": getContextPath() + queryUrl,
            "method": 'post'
        }
    });

    return t;
}