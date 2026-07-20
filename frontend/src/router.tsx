import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import Register from "./pages/Register";
import NotFound from "./pages/NotFound";
import Admin from "./pages/Admin";
import Login from "./pages/Login";

export const router = createBrowserRouter([
  {path: "/", element: <App/>},
  {path: "/register", element: <Register/>},
  {path: "/login", element: <Login/>},
  {path: "/admin", element: <Admin/>},
  {path: "*", element: <NotFound/>}
]);