import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { NameForm } from './components/NameForm'
import Welcome from './components/Welcome'
import UserCard from './components/UserCard'
import ParentComponent from './components/ParentComponent'
import Dashboard from './child-to-parent communication/Dashboard'

function App() {
  const [count, setCount] = useState(0)
  const user = {
    name: "Tilak Raj Sahu",
    email: "tilak@example.com"
  };

  return (
    <>
     
      <h1>Vite + React</h1>
      <Welcome name="{77}" />
      <NameForm/>
      <UserCard name="Tilak" age={22} email="tilak@example.com" />
      <div>
      <h1>React Prop Drilling Example</h1>
      <ParentComponent user={user} />
    </div>
    <div>
      <h1>Weather Dashboard</h1>
      <Dashboard />
    </div>

      
     
    </>
  )
}

export default App
