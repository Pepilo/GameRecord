import Navbar from "./ui/Navbar";
import LinkButton from "./ui/LinkButton";
import ListGroup from "./ListGroup";
import Alert from "./ui/Alert";

import { useState } from 'react'
import RawgGameMainList from "./rawg/RawgGameMainList";

const backlog = [
  "Red dead redemption 2",
  "The witcher 3",
  "Clair obscur Expedition 33",
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

function Home() {

  const[alertVisible, setAlertVisible] = useState(false);

  return (
      <>
          <Navbar firstButtonLabel="Se Connecter" secondButtonLabel= "S'inscrire" firstButtonLink="login" secondButtonLink="register"></Navbar>
          {/* <ListGroup games={backlog} heading="Backlog" onSelectGame={handleSelectGame}/>
          <ListGroup games={wishlist} heading="Wishlist" onSelectGame={handleSelectGame}/> */}
          <LinkButton onClick={() => setAlertVisible(true)}>Se connecter</LinkButton>
          {alertVisible && <Alert onClick={() => setAlertVisible(false)}> Hello World!</Alert>}
          <RawgGameMainList/>
      </>
  );
}

export default Home;