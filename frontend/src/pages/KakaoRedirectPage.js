import React, { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';

const KakaoRedirectPage = () => {
    const location = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
        const handleOAuthKakao = async (code) => {
            try {
                const response = await axios.get(`http://localhost:8080/oauth/login/kakao?code=${code}`);
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
            handleOAuthKakao(code);
        }
    }, [location, navigate]);

    return (
        <div>
            <div>Processing Kakao OAuth2...</div>
        </div>
    );
};

export default KakaoRedirectPage;
