import { createBrowserRouter } from "react-router-dom";
import Home from "./components/Home";
import Register from "./components/auth/Register";
import NotFound from "./components/NotFound";
import Admin from "./components/admin/Admin";
import Login from "./components/auth/Login";

export const router = createBrowserRouter([
  {path: "/", element: <Home/>},
  {path: "/register", element: <Register/>},
  {path: "/login", element: <Login/>},
  {path: "/admin", element: <Admin/>},
  {path: "*", element: <NotFound/>}
]);