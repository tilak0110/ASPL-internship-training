import PropTypes from 'prop-types';

function Welcome({name='Guest'}) {
  return <h1>Hello, {name}!</h1>;
}

Welcome.propTypes = {
  name: PropTypes.string.isRequired,
};
export default Welcome;