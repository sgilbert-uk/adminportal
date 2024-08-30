import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './pages/Home'
import Organisation from './pages/Organisation'
import Employee from './pages/Employee'
import NoPage from './pages/NoPage'

export default function App(){

    return(
        <div>
        <BrowserRouter>
            <Routes>
                <Route index element={<Home />} />
                <Route path="/Home" element={<Home />} />
                <Route path="/Organisation" element={<Organisation />} />
                <Route path="/Employee" element={<Employee />} />
                <Route path="*" element={<NoPage />} />
            </Routes>
        </BrowserRouter>
        </div>
    )
}