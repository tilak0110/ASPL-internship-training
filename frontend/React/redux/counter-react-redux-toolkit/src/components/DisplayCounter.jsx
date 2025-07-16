import { useSelector } from "react-redux";

const DisplayCounter = () => {
  const counterValue = useSelector((store) => store.counter.counterVal);

  return (
    <p className="lead mb-4">
      Counter Current Value: <span className="fw-bold">{counterValue}</span>
    </p>
  );
};

export default DisplayCounter;
