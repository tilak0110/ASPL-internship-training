import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { NameForm } from './components/NameForm'
import Welcome from './components/Welcome'
import UserCard from './components/UserCard'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     
      <h1>Vite + React</h1>
      <Welcome name="{77}" />
      <NameForm/>
      <UserCard name="Tilak" age={22} email="tilak@example.com" />

      
     
    </>
  )
}

export default App
