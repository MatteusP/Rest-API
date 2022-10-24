<template>
    <Layout>
    <form @submit.prevent="submitForm">
      <div class="space-y-6">
        <h1 class="text-2xl font-bold text-stone-600" >Cadastro de Cidadão</h1>  
        <div class="bg-white shadow px-4 py-5 sm:rounded-lg sm:p-6">
          <div class="md:grid md:grid-cols-3 md:gap-6">
            <div class="md:col-span-1">
              <h3 class="text-lg font-medium leading-6 text-gray-900">Informações Pessoais</h3>
            </div>
            <div class="mt-5 md:mt-0 md:col-span-2">
                  <div class="grid grid-cols-6 gap-6">
                    <div class="col-span-6 sm:col-span-6">
                    <label for="first-name" class="block text-sm font-medium text-gray-700">Nome Completo</label>
                    <input v-model="form.nome" type="text" name="first-name" id="first-name" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md" />
                    <p v-if="form.errors.nome" class="text-xs text-red-500">{{form.errors.nome}}</p>
                  </div>
                  <div class="col-span-6 sm:col-span-3">
                    <label for="first-name" class="block text-sm font-medium text-gray-700">CPF</label>
                    <input v-model="form.cpf" type="text" name="first-name" id="first-name" v-mask="'###.###.###-##'" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md" />
                    <p v-if="form.errors.cpf" class="text-xs text-red-500">{{form.errors.cpf}}</p>
                  </div>
    
                  <div class="col-span-6 sm:col-span-3">
                    <label for="last-name" class="block text-sm font-medium text-gray-700">rg</label>
                    <input v-model="form.rg" type="text" name="last-name" id="last-name" v-mask="'###########'" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md" />
                    <p v-if="form.errors.rg" class="text-xs text-red-500">{{form.errors.rg}}</p>
                  </div>
    
                  <div class="col-span-6 sm:col-span-2">
                    <label for="first-name" class="block text-sm font-medium text-gray-700">Data de Nascimento</label>
                    <input v-model="form.dt_nascimento" type="date" name="first-name" id="first-name" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md" />
                    <p v-if="form.errors.dt_nascimento" class="text-xs text-red-500">{{form.errors.dt_nascimento}}</p>
                  </div>
    
                  <div class="col-span-6 sm:col-span-4">
                    <label for="mae" class="block text-sm font-medium text-gray-700">Mãe</label>
                    <input v-model="form.mae" type="text" name="mae" id="mae"  class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md" />
                    <p v-if="form.errors.mae" class="text-xs text-red-500">{{form.errors.mae}}</p>
                  </div>

                  <div class="col-span-6 sm:col-span-2">
                    <label for="first-name" class="block text-sm font-medium text-gray-700">Data de Cadastro</label>
                    <input v-model="form.dt_cadastro" type="date" name="first-name" id="first-name" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md" />
                    <p v-if="form.errors.dt_cadastro" class="text-xs text-red-500">{{form.errors.dt_cadastro}}</p>
                  </div>
    
                </div>
            </div>
          </div>
        </div>
        <div class="flex justify-end mt-4">
          <button type="submit" class="ml-3 inline-flex justify-center py-2 px-6 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Salvar</button>
        </div>
      </div>
    </form>
    </Layout>
    </template>
    
    <script setup>
    import {mask as vMask} from 'vue-the-mask'
    
    const props = defineProps({
        usuarios: Object
    })
    
    const form = useForm({
        nome: null,
        cpf: null,
        rg: null,
        dt_nascimento: null,
        mae: null,
        dt_cadastro:null
    
    })
    
    
    const submitForm = () => {
        form.transform((data) => ({
            ...data,
        }))
        .post(route('usuario.post'), { preserveScroll : true, preserveState: true});
    }
    
    </script>
    