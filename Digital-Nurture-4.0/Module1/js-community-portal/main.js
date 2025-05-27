// 1. JS Setup
console.log("Welcome to the Community Portal");
window.onload = () => alert("🚀 Page Loaded");

// 2. Data Types
const eventName = "Community Music Night";
const eventDate = "2025-06-01";
let availableSeats = 50;
console.log(`🎵 ${eventName} on ${eventDate}, Seats: ${availableSeats}`);

// 3. Conditionals & Loop
let allEvents = [
  { name: "Music Fest", date: "2025-06-05", category: "Music", seats: 20 },
  { name: "Baking Workshop", date: "2025-05-10", category: "Workshop", seats: 0 },
  { name: "Book Meetup", date: "2024-12-01", category: "Meetup", seats: 10 }
];

// Filter upcoming and available events
const today = new Date().toISOString().split("T")[0];
const validEvents = allEvents.filter(e => e.date >= today && e.seats > 0);

// 4. Functions & Closures
function addEvent(event) {
  allEvents.push(event);
}

function registerUser(name, eventName) {
  try {
    const event = allEvents.find(e => e.name === eventName);
    if (!event || event.seats < 1) throw "No seats available!";
    event.seats--;
    console.log(`${name} registered for ${event.name}`);
  } catch (err) {
    console.error("❌", err);
  }
}

function filterEventsByCategory(category) {
  return allEvents.filter(e => e.category === category);
}

// Closure for tracking registrations
function createRegistrationTracker() {
  let count = 0;
  return function () {
    count++;
    console.log(`Total registrations: ${count}`);
  };
}
const trackReg = createRegistrationTracker();

// 5. Objects & Prototypes
function Event(name, date, category, seats) {
  this.name = name;
  this.date = date;
  this.category = category;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};
console.log(Object.entries(new Event("Art Expo", "2025-08-01", "Workshop", 10)));

// 6. Arrays
allEvents.push({ name: "Poetry Night", date: "2025-07-01", category: "Music", seats: 15 });
const musicEvents = allEvents.filter(e => e.category === "Music");
const formatted = allEvents.map(e => `${e.category} on ${e.name}`);
console.log("Formatted Events:", formatted);

// 7. DOM Manipulation
function displayEvents(events) {
  const container = document.querySelector("#eventsContainer");
  container.innerHTML = '';
  events.forEach(event => {
    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML = `<h3>${event.name}</h3><p>${event.date}</p><p>${event.category}</p><p>Seats: ${event.seats}</p><button onclick="handleRegister('${event.name}')">Register</button>`;
    container.appendChild(card);
  });

  // Update form dropdown
  const dropdown = document.forms["registrationForm"].elements["eventSelect"];
  dropdown.innerHTML = '';
  events.forEach(e => {
    dropdown.innerHTML += `<option value="${e.name}">${e.name}</option>`;
  });
}
displayEvents(validEvents);

// 8. Event Handling
document.querySelector("#categoryFilter").onchange = e => {
  const cat = e.target.value;
  const filtered = cat ? filterEventsByCategory(cat) : allEvents;
  displayEvents(filtered);
};

document.querySelector("#searchEvent").onkeydown = e => {
  const text = e.target.value.toLowerCase();
  const results = allEvents.filter(ev => ev.name.toLowerCase().includes(text));
  displayEvents(results);
};

window.handleRegister = name => {
  registerUser("Guest", name);
  trackReg();
  displayEvents(allEvents); // update seat count
};

// 9. Async - Fetch Mock
async function loadMockEvents() {
  document.querySelector("#spinner").style.display = "block";
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts?_limit=3");
    const data = await res.json();
    console.log("Mock API Events:", data);
  } catch (e) {
    console.error("Failed to fetch events", e);
  } finally {
    document.querySelector("#spinner").style.display = "none";
  }
}
loadMockEvents();

// 10. Modern JS Features
const greet = (name = "User") => `Hi, ${name}`;
const [firstEvent] = allEvents;
const { name: eName, category } = firstEvent;
const cloneEvents = [...allEvents];
console.log("Cloned:", cloneEvents);

// 11. Forms
document.getElementById("registrationForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const name = this.elements["name"].value;
  const email = this.elements["email"].value;
  const selectedEvent = this.elements["eventSelect"].value;

  if (!name || !email || !selectedEvent) {
    document.getElementById("formMsg").textContent = "⚠️ Please fill all fields!";
    return;
  }

  registerUser(name, selectedEvent);
  document.getElementById("formMsg").textContent = `✅ Registered for ${selectedEvent}`;
});

// 12. AJAX & Fetch POST
function sendToServer(userData) {
  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      body: JSON.stringify(userData),
      headers: { "Content-type": "application/json" }
    })
      .then(res => res.json())
      .then(data => console.log("📤 Sent to server:", data))
      .catch(err => console.error("❌ Server error", err));
  }, 1000);
}
sendToServer({ name: "Alice", event: "Music Fest" });

// 13. Debugging
console.log("👀 Submitting registration...");
console.log("✅ Form setup OK");

// 14. jQuery + Fade
$("#registerBtn").click(function () {
  $("#eventsContainer .card").fadeOut(500).fadeIn(500);
});
