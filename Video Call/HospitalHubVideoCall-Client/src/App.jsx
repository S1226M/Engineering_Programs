import React, { useState } from "react";
import JoinScreen from "./Components/JoinScreen";
import MeetingRoom from "./Components/MeetingRoom";

function App() {
  const [meetingId, setMeetingId] = useState(null);
  const [participantName, setParticipantName] = useState("");

  return meetingId ? (
    <MeetingRoom meetingId={meetingId} name={participantName} />
  ) : (
    <JoinScreen setMeetingId={setMeetingId} setParticipantName={setParticipantName} />
  );
}

export default App;
