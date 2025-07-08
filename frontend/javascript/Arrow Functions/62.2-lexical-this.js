// 62.2-lexical-this.js
const person = {
  name: "Tilak",
  greet: function () {
    setTimeout(() => {
      console.log(`Hello from ${this.name}`); // 'this' is lexically bound
    }, 1000);
  },
};

person.greet(); // Output after 1s: Hello from Tilak
