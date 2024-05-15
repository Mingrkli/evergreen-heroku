<template>
    <div id="ticket-view">
        <main>
            <div>
                <div id="message-name">
                    <router-link to="/" class="btn">Back</router-link>
                    <h3>Ticket Subject Here</h3>
                </div>

                <div id="messages">
                    <!-- Message -->
                    <div class="message">
                        <div class="message-top">
                            <div>
                                <img
                                    src="../assets/cat.jpg"
                                    alt="Profile Picture"
                                />
                                <h4>User Name Here</h4>
                            </div>

                            <div class="date">
                                <p>October 17, 2006</p>
                                <p>3:26PM</p>
                            </div>
                        </div>

                        <div class="message-bottom">
                            <p>
                                Lorem ipsum dolor, sit amet consectetur
                                adipisicing elit. Velit aliquam deserunt maiores
                                reprehenderit ipsum labore fuga excepturi
                                officiis laboriosam, repudiandae non modi sed
                                fugit atque iure amet! Rerum, quidem vel!
                            </p>
                        </div>
                    </div>

                    <!-- Note -->
                    <div class="note">
                        <p>Someone assigned ticket #4502 to Cody</p>
                        <p>October 17, 2006 4:14PM</p>
                    </div>

                    <!-- Message -->
                    <div class="message">
                        <div class="message-top">
                            <div>
                                <img
                                    src="../assets/cat.jpg"
                                    alt="Profile Picture"
                                />
                                <h4>User Name Here</h4>
                            </div>

                            <div class="date">
                                <p>October 17, 2006</p>
                                <p>3:26PM</p>
                            </div>
                        </div>

                        <div class="message-bottom">
                            <p>
                                Lorem ipsum dolor, sit amet consectetur
                                adipisicing elit. Velit aliquam deserunt maiores
                                reprehenderit ipsum labore fuga excepturi
                                officiis laboriosam, repudiandae non modi sed
                                fugit atque iure amet! Rerum, quidem vel!
                            </p>
                        </div>
                    </div>

                    <!-- Note -->
                    <div class="note">
                        <p>Someone added #Not an issue labels</p>
                        <p>October 17, 2006 4:14PM</p>
                    </div>
                </div>
            </div>

            <form id="message-box">
                <textarea placeholder="Type a message..."></textarea>
                <div id="message-box-btns">
                    <button type="button" id="default-btn">Default</button>
                    <button type="button" id="submit-btn">Submit</button>
                </div>
            </form>
        </main>

        <aside>
            <div>
                <h2>Ticket Overview</h2>
                <p>
                    Ticket ID: <a href="#"><span>4502</span></a>
                </p>
                <p>Created: <span>25 Nov 2024</span></p>
                <p>Last Message: <span>27 Nov 2024</span></p>
                <p>Status: <span class="open">OPEN</span></p>
                <p>Group ID: <span>456685442</span></p>
                <p>Priority: <span>Critical</span></p>
                <p>Type: <span>Critical</span></p>
            </div>
            <div>
                <h2>Responsibility</h2>
            </div>
        </aside>
    </div>
</template>
