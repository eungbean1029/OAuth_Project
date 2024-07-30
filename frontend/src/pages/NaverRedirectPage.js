import React, { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';

const NaverRedirectPage = () => {
    const location = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
        const handleOAuthNaver = async (code) => {
            try {
                const response = await axios.get(`http://localhost:8080/oauth/login/naver?code=${code}`);
                const data = response.data;
                alert("로그인 성공: " + data);
                navigate("/success");
            } catch (error) {
                navigate("/fail");
            }
        };

        const searchParams = new URLSearchParams(location.search);
        const code = searchParams.get('code');
        if (code) {
            alert("CODE = " + code);
            handleOAuthNaver(code);
        }
    }, [location, navigate]);

    return (
        <div>
            <div>Processing Naver OAuth2...</div>
        </div>
    );
};

export default NaverRedirectPage;
