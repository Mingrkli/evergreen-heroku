<template>
    <div id="ticket-view">
        <main>
            <div>
                <div id="message-name">
                    <router-link to="/" class="btn">Back</router-link>
                    <h3>{{ticket.name}}</h3>
                </div>

                <div id="messages">
                  <!-- For each message in the ticketMessages, we'll show each of the message -->
                  <div v-for="message in ticketMessages" class="message">
                    <div class="message-top">
                      <div>
                        <img
                            src="../assets/cat.jpg"
                            alt="Profile Picture"
                        />
                        <h4>{{message.username}}</h4>
                      </div>

                      <div class="date">
                        <p>{{message.created}}</p>
                      </div>
                    </div>

                    <div class="message-bottom">
                      <p>
                        {{message.message}}
                      </p>
                    </div>
                  </div>
                </div>
            </div>

            <form id="message-box">
                <textarea v-model="ticketMessage.message" placeholder="Type a message..."></textarea>
                <div id="message-box-btns">
                    <button type="button" id="default-btn">Default</button>
                    <button type="submit" id="submit-btn" @click.prevent="addMessage">Submit</button>
                </div>
            </form>
        </main>

        <aside>
            <div>
                <h2>Ticket Overview</h2>
                <p>
                    Ticket ID: <a href="#"><span>{{ticket.id}}</span></a>
                </p>
                <p>Created: <span>{{ticket.created}}</span></p>
                <p>Last Message: <span>{{ticket.lastMessage}}</span></p>
                <p>Status: <span class="open">{{ticket.status}}</span></p>
                <p>Group ID: <span>{{ticket.groupID}}</span></p>
                <p>Priority: <span>{{ticket.priority}}</span></p>
                <p>Type: <span>{{ticket.type}}</span></p>
            </div>
            <div>
                <h2>Responsibility</h2>
            </div>
        </aside>
    </div>
</template>

<script>
export default {
  data() {
    return {
      ticketMessages: [],
      ticket: {},
      ticketMessage: {
        message: "",
        created: "not implemented",
        username: "not implemented",
      }
    };
  },
  methods: {
    // Fetch all the tickets, save it into tickets array
    getTicketMessages() {
      // "this.$route.params.index" will get the index number and ".index" is from routes and you can call it whatever
      // you want I just liked index XD
      fetch(`http://localhost:8080/ticket/${this.$route.params.index}/messages`)
          .then((res) => res.json())
          .then((data) => {
            this.ticketMessages = data;

            // TESTING
            // console.log(data);
          });
    },

    // This will get the current ticket information so that we can use it on the aside
    getTicket() {
      fetch(`http://localhost:8080/ticket/${this.$route.params.index}`)
          .then((res) => res.json())
          .then((data) => {
            this.ticket = data;

            // TESTING
            // console.log(data);
          });
    },

    // This will add the message to the database on the current ticket
    addMessage() {
      fetch(`http://localhost:8080/add/message/${this.$route.params.index}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.ticketMessage),
      }).then((data) => {
        // After a messaged is added we will run the getTicketMessages() function which then should allow it to show up
        // in the messages area without the user needing to refresh the page themselves :D
        this.getTicketMessages();

        // TESTING
        // console.log(data);
      });
    },
  },
  beforeMount() {
    this.getTicketMessages();
    this.getTicket();
  },
};
</script>