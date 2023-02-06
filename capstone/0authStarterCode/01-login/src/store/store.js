import Vuex from 'vuex'


export default new Vuex.Store({
      state: {
        count: 0,
        user: {},
        isManager: null,
        isActivated: null,
        id: null,
      },
mutations: {
    increment(state) {
      state.count++
    },
    setUser(state, user) {
     state.user = user
    },
    setIsManager(state, isManager) {
      state.isManager = isManager
    },
    setIsActivated(state, isActivated) {
      state.isActivated = isActivated
    },
    setId(state, id) {
      state.id = id
    },
    },
})

const app = createApp({ /* your root component */ })

// Install the store instance as a plugin
app.use(store)