import { useEffect } from "react";
import Auth from "./pages/Auth/Auth";
import { useDispatch, useSelector } from "react-redux";
import { getUser } from "./redux/Auth/Action";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home/Home";
import Navbar from "./pages/Navbar/Navbar";
import ProjectDetails from "./pages/Project/ProjectDetails";
import IssueDetails from "./pages/Issue/IssueDetails";
import UpdateProjectForm from "./pages/Project/UpdateProjectForm";
import Loader from "./pages/Loader/Loader";
import AcceptInvitation from "./pages/Project/AcceptInvitation";

function App() {
  const dispatch = useDispatch();
  const  auth  = useSelector((store) => store.auth);
  useEffect(() => {
    dispatch(getUser(auth.jwt || localStorage.getItem("jwt")));
  }, [auth.jwt]);

  return (
    <>
      
      {auth.loading?<Loader/> : auth.user ? (
        <>
          <Navbar />
          <Routes>
            <Route path="/" element={<Home />}></Route>
            <Route path="/project/:id" element={<ProjectDetails />}></Route>
            <Route path="/project/update/:id" element={<UpdateProjectForm />}></Route>
            <Route
              path="/project/:projectId/issue/:issueId"
              element={<IssueDetails />}
            ></Route>
             <Route
              path="/accept_invitation"
              element={<AcceptInvitation />}
            ></Route>
          </Routes>
        </>
      ) : (
        <Auth />
      )}
    </>
  );
}

export default App;
