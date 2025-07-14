import './App.css'
import Greet from './components/Greet'
import Hello from './components/Hello'
import NoPropsComponent from './components/NoPropsComponent'

function App() {

  return (
    <>
      
      <h1>Typescript + React</h1>

      <Greet myname='Tilak'/>
      <Hello message='Namastey dosto '/>
      <NoPropsComponent/>
            
    </>
  )
}

export default App
