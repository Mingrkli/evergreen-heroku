import { createRouter, createWebHashHistory } from "vue-router";
import TicketList from "../views/TicketList.vue";
import TicketView from "../views/TicketView.vue";
import TicketCreate from "../views/TicketCreate.vue";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        // Home would show the ticket list
        {
            path: "/",
            name: "Ticket List",
            component: TicketList,
        },
        // /:index means that the path now expects an index (or whatever you want to name it)
        {
            path: "/ticket/:index/chat",
            name: "Ticket View",
            component: TicketView,
        },
        // Creating a Ticket
        {
            path: "/create",
            name: "Ticket Create",
            component: TicketCreate,
        },
    ],
});

export default router;
