import './App.css'
import Home from './components/Home'
import ListGroup from './components/ListGroup'

const backlog = [
  "Red dead redemption 2",
  "The witcher 3",
  "Clair obscur Expidition 33",
  "Bloodborne",
  "Monster hunter world"
]

const wishlist = [
  "Elden Ring",
  "Persona 5",
  "Hollow Knight"
]

const handleSelectGame = (game: string) => {
  console.log(game);
}

function App() {
  return (
    <>
      <div><ListGroup games={backlog} heading="Backlog" onSelectGame={handleSelectGame}/></div>
      <div><ListGroup games={wishlist} heading="Wishlist" onSelectGame={handleSelectGame}/></div>
    </>
  );
}

export default App
