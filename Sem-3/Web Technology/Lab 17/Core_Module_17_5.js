function handler(event) {}

const target = new EventTarget();
target.addEventListener('foo', handler, { capture: true }); 
target.addEventListener('foo', handler, { capture: false });

target.removeEventListener('foo', handler);

target.removeEventListener('foo', handler, { capture: true });