//import React from 'react'  //import for class implementation 
import {useState} from 'react';
import Header from "./components/Header";
import Tasks from "./components/Tasks";
import AddTask from './components/AddTask';

//class implemantation - start
/* class App extends React.Component{
  render(){
    return <h1>Hello from react</h1>
  }
} */
//end

const App = ()=> {

  const [showAddTask, setShowAddTask ] = useState(false)

  const [tasks,setTasks] = useState([
    {
      "id": 1,
      "text": "Doctors Appointment",
      "day": "Feb 5th at 2:30pm",
      "reminder": true
    },
    {
      "id": 2,
      "text": "Meeting at School",
      "day": "Feb 6th at 1:30pm",
      "reminder": true
    }
  ])

  //Add Task
  const addTask = (task) => {
    const id = Math.floor(Math.random()*10000) +1
    const newTask = {id, ...task }
    setTasks([...tasks,newTask])
  }

  //Delete Task
  const deleteTask = (id)=>{
    //console.log('delete',id)
    setTasks(tasks.filter((task)=> task.id !== id))
  }

  //Toggle Reminder
  const toggleReminder= (id) => {
    //console.log(id)
    setTasks(
      tasks.map((task)=>
        task.id === id ? {...task,reminder : !task.reminder} : task ))
  }

 /*  const updateShowAddTask = () => {
    setShowAddTask(!showAddTask)
  } */

  return (
    <div className='container'>
      <Header onAdd={()=>setShowAddTask(!showAddTask)} showAdd={showAddTask}/>  
      {showAddTask && <AddTask onAdd={addTask} />}
      {tasks.length > 0 ?(
        <Tasks tasks={tasks} onDelete={deleteTask} onToggle={toggleReminder}/>
        ):('No Taskst to display')
      }
      </div>
  );
}

export default App;
