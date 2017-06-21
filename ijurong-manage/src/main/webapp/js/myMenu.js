var menuGenerator = (function () {
    var myMenus;

    function init(data) {
        menus = {};
        myMenus = [];
        var deleteId = [];
        for (var i = 0; i < data.length; i++) {
            menus[data[i].id] = data[i];
        }
        for (var i = 0; i < data.length; i++) {
            var parentId = data[i].parentId;
            if (parentId) {
                var parentMenu = menus[parentId];
                if (!parentMenu.children) {
                    parentMenu.children = [];
                }
                parentMenu.children.push(data[i]);
            }
        }
        for (var key in menus) {
            var temp = menus[key];
            if (!temp.parentId) {
                myMenus.push(temp);
            }
        }
        return myMenus;
    }

    function generateMain() {
        var htmls = [];
        for(var i = 0; i < myMenus.length; i++) {
            var menu = myMenus[i];
            var id = menu.permissionCode.split(':')[0];
            var html = '<li><a href="javascript:;" id="' + id + '">' + menu.permissionName + '</a></li>';
            htmls.push(html);
        }
        $('#topMenu').html(htmls.join(''));
    }

    function generateSubMenu() {
        var htmls = [];
        var index = 0;
        for(var i = 0; i < myMenus.length; i++) {
            var menu = myMenus[i];
            var html = '';
            var id = menu.permissionCode.split(':')[0];
            if(i == 0) {
                html += '<ul class="nav" id="nav_' + id + '">';
            } else {
                html += '<ul class="nav" id="nav_' + id + '" style="display: none;">';
            }
            for(var j = 0; j < menu.children.length; j++) {
                var subMenu = menu.children[j];
                html += '<li class="nav-li"> <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">' + subMenu.permissionName + '</span></a>';
                if(i == 0 && j== 0) {
                    html += '<ul class="subnav  current">';
                } else {
                    html += '<ul class="subnav">';
                }
                for(var k = 0; k < subMenu.children.length; k++) {
                    var childMenu = subMenu.children[k];
                    html += '<li class="subnav-li" href="' + childMenu.url + '" data-id="' +index++ + '"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">' + childMenu.permissionName + '</span></a></li>';
                }
                html += '</ul>';
                html += '</li>';
            }
            html += '</ul>';
            htmls.push(html);
        }
        $('#subMenu').html(htmls.join(''));
    }

    return {
      init: init,
        generateMain: generateMain,
        generateSubMenu: generateSubMenu
    };
})();