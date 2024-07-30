import React from 'react';

const Login = () => {
    return (
        <div>
            <h1>Login with OAuth2</h1>
            <a href="/oauth2/authorization/google">Login with Google</a><br />
            <a href="/oauth2/authorization/kakao">Login with Kakao</a><br />
            <a href="/oauth2/authorization/naver">Login with Naver</a>
        </div>
    );
};

export default Login;
