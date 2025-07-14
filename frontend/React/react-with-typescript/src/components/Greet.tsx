import React from "react";

type Props = {
    myname: string;
};

const Greet: React.FC<Props>=({myname})=>{
    return <h1>Hello , {myname}</h1>
};

export default Greet;