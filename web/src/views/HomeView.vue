<!--<template>-->
<!--  <a-layout-content style="padding: 0 50px">-->
<!--    <a-breadcrumb style="margin: 16px 0">-->
<!--      <a-breadcrumb-item>Home</a-breadcrumb-item>-->
<!--      <a-breadcrumb-item>List</a-breadcrumb-item>-->
<!--      <a-breadcrumb-item>App</a-breadcrumb-item>-->
<!--    </a-breadcrumb>-->
<!--    <a-layout style="padding: 24px 0; background: #fff">-->
<!--      <a-layout-sider width="200" style="background: #fff">-->
<!--        <a-menu-->
<!--            v-model:selectedKeys="selectedKeys2"-->
<!--            v-model:openKeys="openKeys"-->
<!--            mode="inline"-->
<!--            style="height: 100%"-->
<!--        >-->
<!--          <a-sub-menu key="sub1">-->
<!--            <template #title>-->
<!--                <span>-->
<!--                  <user-outlined />-->
<!--                  subnav 1-->
<!--                </span>-->
<!--            </template>-->
<!--            <a-menu-item key="1">option1</a-menu-item>-->
<!--            <a-menu-item key="2">option2</a-menu-item>-->
<!--            <a-menu-item key="3">option3</a-menu-item>-->
<!--            <a-menu-item key="4">option4</a-menu-item>-->
<!--          </a-sub-menu>-->
<!--          <a-sub-menu key="sub2">-->
<!--            <template #title>-->
<!--                <span>-->
<!--                  <laptop-outlined />-->
<!--                  subnav 2-->
<!--                </span>-->
<!--            </template>-->
<!--            <a-menu-item key="5">option5</a-menu-item>-->
<!--            <a-menu-item key="6">option6</a-menu-item>-->
<!--            <a-menu-item key="7">option7</a-menu-item>-->
<!--            <a-menu-item key="8">option8</a-menu-item>-->
<!--          </a-sub-menu>-->
<!--          <a-sub-menu key="sub3">-->
<!--            <template #title>-->
<!--                <span>-->
<!--                  <notification-outlined />-->
<!--                  subnav 3-->
<!--                </span>-->
<!--            </template>-->
<!--            <a-menu-item key="9">option9</a-menu-item>-->
<!--            <a-menu-item key="10">option10</a-menu-item>-->
<!--            <a-menu-item key="11">option11</a-menu-item>-->
<!--            <a-menu-item key="12">option12</a-menu-item>-->
<!--          </a-sub-menu>-->
<!--        </a-menu>-->
<!--      </a-layout-sider>-->
<!--      <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">-->
<!--        <a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="poems">-->
<!--          <template #footer>-->
<!--            <div>-->
<!--              <b>ant design vue</b>-->
<!--              footer part-->
<!--            </div>-->
<!--          </template>-->
<!--          <template #renderItem="{ item }">-->
<!--            <a-list-item key="item.title">-->
<!--              <template #actions>-->
<!--          <span v-for="{ type, text } in actions" :key="type">-->
<!--            <component :is="type" style="margin-right: 8px" />-->
<!--            {{ text }}-->
<!--          </span>-->
<!--              </template>-->
<!--              <template #extra>-->
<!--                <img-->
<!--                    width="272"-->
<!--                    alt="logo"-->
<!--                    src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"-->
<!--                />-->
<!--              </template>-->
<!--              <a-list-item-meta :description="item.authorName">-->
<!--                <template #title>-->
<!--                  <a :href="item.href">{{ item.title }}</a>-->
<!--                </template>-->
<!--                <template #avatar><a-avatar :src="item.avatar" /></template>-->
<!--              </a-list-item-meta>-->
<!--              {{ item.paragraphs }}-->
<!--            </a-list-item>-->
<!--          </template>-->
<!--        </a-list>-->

<!--      </a-layout-content>-->
<!--    </a-layout>-->
<!--  </a-layout-content>-->
<!--</template>-->
<!--<script lang="ts">-->

<!--import {defineComponent, onMounted, reactive, ref} from 'vue';-->
<!--import { StarOutlined, LikeOutlined, MessageOutlined } from '@ant-design/icons-vue';-->
<!--import axios from "axios";-->
<!--const listData: Record<string, string>[] = [];-->

<!--for (let i = 0; i < 23; i++) {-->
<!--  listData.push({-->
<!--    href: 'https://www.antdv.com/',-->
<!--    title: `ant design vue part ${i}`,-->
<!--    avatar: 'https://joeschmoe.io/api/v1/random',-->
<!--    description:-->
<!--        'Ant Design, a design language for background applications, is refined by Ant UED Team.',-->
<!--    content:-->
<!--        'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',-->
<!--  });-->
<!--}-->
<!--export default defineComponent({-->
<!--  components: {-->
<!--    StarOutlined,-->
<!--    LikeOutlined,-->
<!--    MessageOutlined,-->
<!--  },-->
<!--  setup(){-->
<!--    const poems = ref();-->
<!--    const ebook1 = reactive({books:[]});-->
<!--    onMounted(()=>{-->
<!--      console.log("onMounted");-->
<!--      axios.get("/poem/list?title=即事").then(-->
<!--          (response) => {-->
<!--            const data = response.data;-->
<!--            poems.value = data.content;-->
<!--            ebook1.books = data.content;-->
<!--            console.log(response);-->
<!--          });-->
<!--    })-->
<!--    const pagination = {-->
<!--      onChange: (page: number) => {-->
<!--        console.log(page);-->
<!--      },-->
<!--      pageSize: 3,-->
<!--    };-->
<!--    const actions: Record<string, string>[] = [-->
<!--      { type: 'StarOutlined', text: '156' },-->
<!--      { type: 'LikeOutlined', text: '156' },-->
<!--      { type: 'MessageOutlined', text: '2' },-->
<!--    ];-->
<!--    return {-->
<!--      poems,-->
<!--      pagination,-->
<!--      actions,-->
<!--    }-->
<!--  },-->
<!--});-->
<!--</script>-->
<!--<style>-->
<!--#components-layout-demo-side .logo {-->
<!--  height: 32px;-->
<!--  margin: 16px;-->
<!--  background: rgba(255, 255, 255, 0.3);-->
<!--}-->

<!--.site-layout .site-layout-background {-->
<!--  background: #fff;-->
<!--}-->
<!--[data-theme='dark'] .site-layout .site-layout-background {-->
<!--  background: #141414;-->
<!--}-->
<!--</style>-->

