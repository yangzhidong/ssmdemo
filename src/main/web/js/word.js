
/**
 * 主要功能：textArea字数统计
 */
var wordTool = {
    /**
     * 主要功能：初始化插件
     *
     * @param opt = ['#id1', '#id2']
     * @param selector 选择器，可以用id或者class，如：'#id'或'.class'。必填项
     * @param data-max 最大字数，不写默认200个字。非必填项
     * @param data-right 红色数字离文本域右边的距离，左正右负。非必填项
     * @param data-bottom 红色数字离文本域底部的距离，上正下负。非必填项
     */
    init: function (opt) {
        $.each(opt, function (index, item) {
            var sel = item,
                max = $(sel).attr('data-max') ? $(sel).attr('data-max') : 200,
                right = $(sel).attr('data-right') ? Number($(sel).attr('data-right'))+85 : 85,
                bottom = $(sel).attr('data-bottom') ? Number($(sel).attr('data-bottom'))+6 : 6,
                id = sel.substring(1);
            span = '<span class="wordwrap'+ id +'"><var class="word'+ id +'">'+max+'</var>/'+max+'</span>';

            $(sel).append(span);

            wordTool._countInputNum(sel);
            wordTool._initCss(id, right, bottom);
        });

    },
    /**
     * 主要功能：剩余字数统计
     *
     * @param sel 文本框外层div的id值，带'#'
     */
    _countInputNum: function (sel) {
        //先选出 textarea 和 统计字数 dom 节点
        var div = $(sel),
            id = sel.substring(1),
            textArea = div.find('textarea'),
            wordWrap = div.find('.word'+id),
            max = wordWrap.text(),
            curLength = textArea.val().length;

        textArea[0].setAttribute('maxlength', max);
        wordWrap.text(max - curLength);

        textArea.on('input propertychange', function() {
            wordWrap.text(max - $(this).val().length);
        });
        textArea.on('focus', function () {
            textArea.select();
        });
    },
    /**
     * 主要功能：初始化样式
     *
     * @param id 文本框外层div的id值，不带'#'
     * @param right 数字距离文本框右边的距离，只写数字，不带'px'
     * @param left 数字距离文本框底部的距离，只写数字，不带'px'
     */
    _initCss: function (id, right, bottom) {
        $('.wordwrap' + id).css({'position': 'relative', 'right': right + 'px', 'bottom': bottom + 'px'});
        $('.word'+ id).css({'color': '#990000', 'padding': '0 4px'});
    }
};

// 初始化文本域字数限制组件
$(document).ready(function () {
    wordTool.init(['#wordCount1']);
});