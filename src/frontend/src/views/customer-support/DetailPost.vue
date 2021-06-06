<template>
  <v-main>
    <h1>{{ clickedPost }}</h1>
  </v-main>
</template>
<script>
export default {
  props: ["clickedPost"],
  data: () => ({})
};
</script>
<style scoped></style>
