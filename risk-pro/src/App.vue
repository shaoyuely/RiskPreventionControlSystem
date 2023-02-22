<template>
  <div id="app">
    <!-- <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav> -->
    <router-view />
  </div>
</template>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 0px;
}

body {
  margin: 0;
  padding: 0;
  border: 0
}

#loginBG {
  background: url("assets/bod.a9b05e84.png");
  width: 100%;
  height: 100%;
  position: fixed;
  background-size: 100% 100%;
}

.title {
  background-color: #2893ffe0;
  width: 100%;
  min-height: 50px;
}
.infospan{
  margin:10px 1% 5px 1%;
  width:98%;
  border:1px solid lightgray;
  border-radius:8px;
}
.spantitle {
  text-align: center;
  margin:20px 0px;
  font-size: 22px;
}
</style>
