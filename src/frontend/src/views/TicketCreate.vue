<!--Hi Ming, this is Toby from the future...-->
<!--Hi Ming Once again-->
<!--Hi Ming Once again, again...-->
<template>
  <div id="ticket-create">
    <div id="ticket-list-title">
      <h1>Ticket Create</h1>
      <router-link to="/" class="btn">Back</router-link>
    </div>

    <form @submit.prevent="addTicket">
      <div>
        <label for="name">Ticket Name</label>
        <input
            type="text"
            name="name"
            placeholder="Ticket Name"
            v-model="ticket.name"
        />
      </div>

      <div>
        <div id="options">
          <div class="option">
            <label for="priority">Priority</label>
            <select v-model="ticket.priority" name="priority">
              <option value="Low">Low</option>
              <option value="Mid">Mid</option>
              <option value="High">High</option>
              <option value="Critical">Critical</option>
            </select>
          </div>

          <div class="option">
            <label for="type">Type</label>
            <select v-model="ticket.type" name="type">
              <option value="Question">Question</option>
              <option value="Bug">Bug</option>
              <option value="Feature">Feature</option>
            </select>
          </div>
        </div>
      </div>

      <div id="message-box">
        <textarea placeholder="Type a message..."></textarea>
        <div id="message-box-btns">
          <button type="submit" id="submit-btn">Submit</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ticket: {
        name: "",
        created: "",
        lastMessage: "",
        status: "Open",
        groupID: "not implemented",
        priority: "Low",
        type: "Question",
      },
    };
  },
  methods: {
    // Adds a ticket
    addTicket() {
      // gets the current date in this format MM-DD-YYYY | HH:MM
      const date = new Date();
      const currentDate = `${date.getMonth()}/${date.getDate()}/${date.getFullYear()} ${date.getHours()}:${date.
      getMinutes()}`

      // Sets the created and lastMessage data into the currentDate since we expect the created and lastMessage
      // date to be the current date when the ticket is being created
      this.created = currentDate;
      this.lastMessage = currentDate;

      console.log(this.ticket);

      // Adds the ticket to the database
      // fetch("http://localhost:8080/add", {
      //     method: "POST",
      //     headers: {
      //         "Content-Type": "application/json",
      //     },
      //     body: JSON.stringify(this.ticket),
      // }).then((data) => {
      //     // TESTING
      //     // console.log(data);
      //
      //     // Returns user to home
      //     this.$router.push("/");
      // });
    },
  },
};
</script>