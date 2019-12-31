function getUrlParam(name) {
    //����һ������Ŀ�������������ʽ����
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg); //ƥ��Ŀ�����
    if (r != null) {
        return unescape(r[2]);
    } else {
        return null; //���ز���ֵ
    }
}

function getRootPath(){
    //��ȡ��ǰ��ַ���磺 http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //��ȡ������ַ֮���Ŀ¼���磺 uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //��ȡ������ַ���磺 http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //��ȡ��"/"����Ŀ�����磺/uimcardprj/
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+2);
    return(localhostPaht+projectName);
}