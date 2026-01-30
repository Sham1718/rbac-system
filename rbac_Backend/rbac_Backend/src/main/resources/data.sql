-- =========================
-- PERMISSIONS
-- =========================
INSERT INTO permissions (name)
VALUES
    ('USER_READ'),
    ('USER_WRITE'),
    ('ROLE_ASSIGN')
ON CONFLICT (name) DO NOTHING;

-- =========================
-- ROLES
-- =========================
INSERT INTO roles (name)
VALUES
    ('ADMIN'),
    ('USER')
ON CONFLICT (name) DO NOTHING;

-- =========================
-- ROLE → PERMISSION MAPPING
-- =========================

-- ADMIN → ALL permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id
FROM roles r
JOIN permissions p ON true
WHERE r.name = 'ADMIN'
ON CONFLICT DO NOTHING;

-- USER → USER_READ only
INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id
FROM roles r
JOIN permissions p ON p.name = 'USER_READ'
WHERE r.name = 'USER'
ON CONFLICT DO NOTHING;
