import Task from "../models/task.js";
import { printTask, updateTask } from "../../Controller.js";
const TaskOperations = {
  taskarr: [],
  gettotalCount() {
    return this.taskarr.length;
  },
  add(taskobj) {
    // generic to specific
    let task = new Task(taskobj);
    this.taskarr.push(task);
  },
  remove(id) {
    this.taskarr = this.taskarr.filter((e) => e.id !== id);
    this.printArr();
  },
  update(id) {
    const obj = this.taskarr.find((e) => e.id === id);
    this.remove(id);
    updateTask(obj);
  },
  printArr() {
    const tbody = document.querySelector("#itemstask");
    tbody.innerHTML = "";
    if (!this.taskarr.length == 0) {
      for (const key of this.taskarr) {
        console.log("this is the key"+key);
        printTask(key);
      }
    }
  },
};

export default TaskOperations;
