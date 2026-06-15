import { createBrowserRouter } from "react-router-dom";
import Home from "./components/Home";
import Register from "./components/Register";
import NotFound from "./components/NotFound";
import Admin from "./components/Admin";

export const router = createBrowserRouter([
  {path: "/", element: <Home/>},
  {path: "/register", element: <Register/>},
  {path: "/admin", element: <Admin/>},
  {path: "*", element: <NotFound/>}
]);