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
        // This would later turn "/ticket:id" or something like that
        {
            path: "/ticket/4502",
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
