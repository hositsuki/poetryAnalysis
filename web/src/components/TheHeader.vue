<!--<template>-->
<!--  <a-layout-header class="header">-->
<!--    <div class="logo" />-->
<!--    <a-menu-->
<!--        v-model:selectedKeys="selectedKeys1"-->
<!--        theme="dark"-->
<!--        mode="horizontal"-->
<!--        :style="{ lineHeight: '64px' }"-->
<!--    >-->
<!--      <a-menu-item key="/">-->
<!--        <router-link to="/">首页</router-link>-->
<!--      </a-menu-item>-->
<!--      <a-menu-item key="/admin/ebook" :style="user.id? {} : {display:'none'}">-->
<!--        <router-link to="/admin/ebook">电子书管理</router-link>-->
<!--      </a-menu-item>-->
<!--    </a-menu>-->
<!--  </a-layout-header>-->
<!--</template>-->

<!--<script lang="ts">-->
<!--import {defineComponent, ref} from 'vue';-->

<!--export default defineComponent({-->
<!--  name: 'TheHeader',-->
<!--  setup() {-->
<!--    return {-->
<!--      selectedKeys1: ref<string[]>(['2']),-->
<!--      selectedKeys2: ref<string[]>(['1']),-->
<!--      openKeys: ref<string[]>(['sub1']),-->
<!--    };-->
<!--  },-->
<!--});-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->