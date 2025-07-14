type HelloProps = {
  message: string;
};

const Hello: React.FC<HelloProps> = ({ message }) => {
  return <div>{message}</div>;
};

export default Hello;