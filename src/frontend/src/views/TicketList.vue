<template>
    <div id="ticket-list">
        <div id="ticket-list-title">
            <h1>Ticket List</h1>
            <router-link to="/create" class="btn">Create</router-link>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Ticket ID</th>
                    <th>Ticket Name</th>
                    <th>Created</th>
                    <th>Last Message</th>
                    <th>Status</th>
                    <th>Group ID</th>
                    <th>Priority</th>
                    <th>Type</th>
                </tr>
            </thead>

            <tbody>
                <tr
                    v-for="ticket in tickets"
                    :key="ticket.id"
                    @click="goToPage(4502)"
                >
                    <td>{{ ticket.id }}</td>
                    <td>{{ ticket.name }}</td>
                    <td>{{ ticket.created }}</td>
                    <td>{{ ticket.lastMessage }}</td>
                    <td>{{ ticket.status }}</td>
                    <td>{{ ticket.groupID }}</td>
                    <td>{{ ticket.priority }}</td>
                    <td>{{ ticket.type }}</td>
                </tr>

                <!-- <tr v-for="index in 10" @click="goToPage(4502)">
                    <td>4502</td>
                    <td>TICKET SUBJECT HERE</td>
                    <td>25 Nov 2024</td>
                    <td>27 Nov 2024</td>
                    <td>OPEN</td>
                    <td>456685442</td>
                    <td>Critical</td>
                    <td>Critical</td>
                </tr> -->
            </tbody>
        </table>
    </div>
</template>

<script setup>
// Hook
import { useRouter } from "vue-router";

// Gets access to the router
const router = useRouter();

function goToPage(number) {
    router.push({ path: `ticket/${number}` });
}
</script>

<script>
export default {
    data() {
        return {
            tickets: [],
        };
    },
    methods: {
        // Fetch all the tickets, save it into tickets array
        getTickets() {
            fetch("http://localhost:8080/tickets")
                .then((res) => res.json())
                .then((data) => {
                    this.tickets = data;

                    // TESTING
                    // console.log(data);
                });
        },
    },
    beforeMount() {
        this.getTickets();
    },
};
</script>
