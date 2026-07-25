class Task{
    constructor(taskobj){
        for (const key in taskobj) {
            this[key] = taskobj[key];
        }
        // this.ismarked = false
    }
}

export default Task;
// id,title,desc,color,date,url