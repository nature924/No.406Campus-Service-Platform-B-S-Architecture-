const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyuanfuwupingtai/",
            name: "xiaoyuanfuwupingtai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyuanfuwupingtai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园服务平台"
        } 
    }
}
export default base
