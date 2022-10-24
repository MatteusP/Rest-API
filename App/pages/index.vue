<template>
    <Layout>
        <div class="px-4 sm:px-6 lg:px-8">
            <h1 class="text-xl font-semibold text-gray-900">Usuários</h1>
            <form>
                <label for="search" class="block text-sm font-medium text-gray-700 mt-6">Pesquisar</label>
                <div class="flex">
                    <div class="lg:w-1/2 sm:11/12 pr-2">
                        <div class="mt-1 flex rounded-md shadow-sm xl:w-96 lg:w-96 md:w-96">
                            <div class="relative flex items-stretch flex-grow focus-within:z-10">
                                <input v-model="search_nome" type="text" name="search" id="search"
                                    class="focus:ring-indigo-500 focus:border-indigo-500 block w-full rounded-none rounded-l-md pl-2 sm:text-sm border-gray-300" />
                            </div>
                            <button type="submit"
                                class="-ml-px relative inline-flex items-center space-x-2 px-4 py-2 border border-gray-300 text-sm font-medium rounded-r-md text-gray-700 bg-gray-50 hover:bg-gray-100 focus:outline-none focus:ring-1 focus:ring-indigo-500 focus:border-indigo-500">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                                    stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round"
                                        d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                                </svg>
                            </button>
                        </div>
                    </div>
                    <div class="lg:w-1/2 sm:1/12">
                        <div class="mt-1 lg:mt-2 md:mt-1 sm:mt-1 flex justify-end">
                            <Link as="button" :href="route('usuario.novo')"
                                class="rounded-md border border-transparent bg-indigo-600 px-4 py-2 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:w-auto">
                            Cadastrar</Link>
                        </div>
                    </div>
                </div>
            </form>
            <div
                class="-mx-4 mt-8 overflow-hidden shadow ring-1 ring-black ring-opacity-5 sm:-mx-6 md:mx-0 md:rounded-lg">
                <table class="min-w-full divide-y divide-gray-300">
                    <thead class="bg-gray-50">
                        <tr>
                            <th scope="col"
                                class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">Nome</th>
                            <th scope="col" class="relative py-3.5 pl-3 pr-4 sm:pr-6"></th>
                        </tr>
                    </thead>
                    <tbody class="divide-y divide-gray-200 bg-white">
                        <tr v-for="usuario in usuarios.data" :key="usuario.id">
                            <td
                                class="w-full max-w-0 py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:w-auto sm:max-w-none sm:pl-6">
                                {{ usuario.nome }}
                            </td>
                            <td class="py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-6">
                                <Link as="button" :href="route('usuario.detalhe', [usuario.usuario_id])" class="text-indigo-600 hover:text-indigo-900">Detalhes</Link>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="mb-3 ml-4 mr-4">
                    <Pagination :data="usuarios" />
                </div>
            </div>
        </div>
    </Layout>
    
</template>


<script setup>
import Pagination from '../components/Pagination.vue'
import throttle from 'lodash/throttle'
import { watch, ref } from 'vue'

const props = defineProps({
    usuarios: Object,
 
})

</script>
