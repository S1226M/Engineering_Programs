import React, { useState } from "react";
import axios from "axios";

// ✅ Define the helper function correctly
const getMeetingAndToken = async () => {
  const response = await axios.get("http://localhost:5000/api/videosdk");
  return response.data; // should return { token: "...", meetingId: "..." }
};

export default function JoinScreen({ setMeetingId, setParticipantName }) {
  const [name, setName] = useState("");

  const onJoinMeeting = async () => {
    const { token, meetingId } = await getMeetingAndToken();
    setMeetingId(meetingId);
    setParticipantName(name);
    sessionStorage.setItem("videosdkToken", token);
  };

  return (
    <div>
      <h2>Join Meeting</h2>
      <input
        placeholder="Enter your name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <button onClick={onJoinMeeting}>Join</button>
    </div>
  );
}
