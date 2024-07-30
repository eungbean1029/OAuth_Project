import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import GoogleRedirectPage from './pages/GoogleRedirectPage';
import KakaoRedirectPage from './pages/KakaoRedirectPage';
import NaverRedirectPage from './pages/NaverRedirectPage';
import Success from './pages/Success';
import Fail from './pages/Fail';

function App() {
    return (
        <Router>
            <Routes>
                <Route exact path="/" element={<Login />} />
                <Route path="/home" element={<Home />} />
                <Route path="/oauth2/redirect/google" element={<GoogleRedirectPage />} />
                <Route path="/oauth2/redirect/kakao" element={<KakaoRedirectPage />} />
                <Route path="/oauth2/redirect/naver" element={<NaverRedirectPage />} />
                <Route path="/success" element={<Success />} />
                <Route path="/fail" element={<Fail />} />
            </Routes>
        </Router>
    );
}

export default App;
