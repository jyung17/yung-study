const player = {
  name: "nico",
  sayHello: function (otherPersonsName) {
    console.log("hello");
  },
};

function sayHello() {
  console.log("hello2");
}

console.log(player.name); // nico
player.sayHello(); // hello
sayHello(); // hello2
