// setProperty.js
const obj = {};
const key = 'username';

obj[key] = 'Tilak';
console.log(obj); // { username: 'Tilak' }

// Or more dynamic
function setProp(obj, propName, value) {
  obj[propName] = value;
}
setProp(obj, 'email', 'Tilak@example.com');
console.log(obj); // { username: 'Tilak', email: 'Tilak@example.com' }
